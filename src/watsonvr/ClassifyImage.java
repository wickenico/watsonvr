package watsonvr;

import com.ibm.cloud.sdk.core.http.Headers;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
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
		String imageUrl = "https://www.trendswm.de/wp-content/uploads/2015/01/gutmann.jpg";

		// Execute vr
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder().url(imageUrl).build();

		try {
			Headers header = visualRecognition.classify(classifyOptions).execute().getHeaders();
			ClassifiedImages result = visualRecognition.classify(classifyOptions).execute().getResult();
			System.out.println("\n******** Classify with the General model ********\n" + header + result
					+ "\n******** END Classify with the General model ********\n");
		} catch (NotFoundException e) {
			// Handle Not Found (404) exception
		} catch (RequestTooLargeException e) {
			// Handle Request Too Large (413) exception
		} catch (ServiceResponseException e) {
			// Base class for all exceptions caused by error responses from the service
			System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
		}

	}

}
