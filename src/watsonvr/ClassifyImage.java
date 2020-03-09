package watsonvr;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

public class ClassifyImage {

	public static void main(String[] args) {
		
		Keys key = new Keys();		
		IamAuthenticator authenticator = new IamAuthenticator(key.apiKey);
		VisualRecognition visualRecognition = new VisualRecognition("2018-03-15", authenticator);
		visualRecognition.setServiceUrl(key.serviceUrl);

		String imageUrl = "https://www.trendswm.de/wp-content/uploads/2014/10/zulieferer-klein1.jpg";

		ClassifyOptions classifyOptions = new ClassifyOptions.Builder().url(imageUrl).build();
		ClassifiedImages result = visualRecognition.classify(classifyOptions).execute().getResult();
		System.out.println("\n******** Classify with the General model ********\n" + result
				+ "\n******** END Classify with the General model ********\n");

	}

}
