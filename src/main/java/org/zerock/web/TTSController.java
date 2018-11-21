package org.zerock.web;

import java.io.File;

import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ImageVO;
import org.zerock.persistence.ImageDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/tts/*")

public class TTSController {

	@Inject
	private ImageDAO imagedao;

	private static final Logger logger = LoggerFactory.getLogger(TTSController.class);

	@RequestMapping(value = "/audio/{imageNo}", method = RequestMethod.GET)
	public void audio(Locale locale, Model model, @PathVariable("imageNo") int imageNo) {
		// Instantiates a client

		try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
			// Set the text input to be synthesized
			SynthesisInput input = SynthesisInput.newBuilder().setText("Hello, World!").build();

			// Build the voice request, select the language code ("en-US") and the ssml
			// voice gender
			// ("neutral")
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US")
					.setSsmlGender(SsmlVoiceGender.NEUTRAL).build();

			// Select the type of audio file you want returned
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

			// Perform the text-to-speech request on the text input with the selected voice
			// parameters and
			// audio file type
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

			// Get the audio contents from the response
			ByteString audioContents = response.getAudioContent();

			// Write the response to the output file.
			/*
			 * try (OutputStream out = new FileOutputStream("output.mp3")) {
			 * out.write(audioContents.toByteArray());
			 * System.out.println("Audio content written to file \"output.mp3\""); }
			 * 
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/sendSpeech/image/{imageNo}", method = RequestMethod.GET)

	public ResponseEntity sendSpeech(@PathVariable("imageNo") int imageNo, ImageVO imagevo) {
		ResponseEntity entity = null;

		ImageVO imageScript = null;
		try {
			imageScript = imagedao.getScript(imageNo);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
			// Set the text input to be synthesized
			// SynthesisInput input = SynthesisInput.newBuilder().setText("Hello,
			// World!").build();

			SynthesisInput input = SynthesisInput.newBuilder().setText(imageScript.getImageScript()).build();

			// Build the voice request, select the language code ("en-US") and the ssml
			// voice gender
			// ("neutral")
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("ko-KR")
					.setSsmlGender(SsmlVoiceGender.NEUTRAL).build();

			// Select the type of audio file you want returned
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

			// Perform the text-to-speech request on the text input with the selected voice
			// parameters and
			// audio file type
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

			// Get the audio contents from the response
			ByteString audioContents = response.getAudioContent();
			entity = new ResponseEntity(audioContents.toByteArray(), HttpStatus.OK);

			// Write the response to the output file.

			/*
			 * try (OutputStream out = new FileOutputStream("output.mp3")) {
			 * out.write(audioContents.toByteArray());
			 * System.out.println("Audio content written to file \"output.mp3\""); entity =
			 * new ResponseEntity(audioContents.toByteArray() , HttpStatus.OK);
			 * 
			 * 
			 * return entity; }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;

	}

	@RequestMapping(value = "/sendSpeech/url/{text}", method = RequestMethod.GET)

	public ResponseEntity urltextToSpeech(@PathVariable("text") String text) {
		ResponseEntity entity = null;

		try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
			// Set the text input to be synthesized
			// SynthesisInput input = SynthesisInput.newBuilder().setText("Hello,
			// World!").build();

			SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

			// Build the voice request, select the language code ("en-US") and the ssml
			// voice gender
			// ("neutral")
			VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("ko-KR")
					.setSsmlGender(SsmlVoiceGender.NEUTRAL).build();

			// Select the type of audio file you want returned
			AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();

			// Perform the text-to-speech request on the text input with the selected voice
			// parameters and
			// audio file type
			SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

			// Get the audio contents from the response
			ByteString audioContents = response.getAudioContent();
			entity = new ResponseEntity(audioContents.toByteArray(), HttpStatus.OK);

			// Write the response to the output file.

			/*
			 * try (OutputStream out = new FileOutputStream("output.mp3")) {
			 * out.write(audioContents.toByteArray());
			 * System.out.println("Audio content written to file \"output.mp3\""); entity =
			 * new ResponseEntity(audioContents.toByteArray() , HttpStatus.OK);
			 * 
			 * 
			 * return entity; }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;

	}
	
	@RequestMapping(value = "/sendSpeech/view/{text}", method = RequestMethod.GET)
	public String urltextToSpeechView(@PathVariable("text") String text, Model model) {
		model.addAttribute("text", text);
		
		return "tts/speech";
	}

	
	
}





