package watsonvr;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

public class ClassifyImage {

	public static void main(String[] args) {
		
		// Create Object for API settings
		Keys key = new Keys();
		
		// Connecting to Watson Server
		IamAuthenticator authenticator = new IamAuthenticator(key.apiKey);
		VisualRecognition visualRecognition = new VisualRecognition("2018-03-15", authenticator);
		visualRecognition.setServiceUrl(key.serviceUrl);
		
		// Set image for AI analyze
		String imageUrl = "https://www.trendswm.de/wp-content/uploads/2014/10/zulieferer-klein1.jpg";

		// Execute vr
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder().url(imageUrl).build();
		ClassifiedImages result = visualRecognition.classify(classifyOptions).execute().getResult();
		System.out.println("\n******** Classify with the General model ********\n" + result
				+ "\n******** END Classify with the General model ********\n");

	}

}
