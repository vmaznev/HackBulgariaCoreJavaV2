import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class HackBulgariaStudents {

    private static void getStudentsWithMoreThanOneCourse(String apiURL) throws ClientProtocolException, IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(apiURL);

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if ((status >= 200) && (status < 300)) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected Response Status: " + status);
                }
            }

        };
        
        String responseBody = httpClient.execute(getRequest, responseHandler);
        System.out.println(responseBody);
        
        JSONArray jsonArray = new JSONArray(responseBody);
        
        System.out.println("Students With More Than Course...! ");
        System.out.println();
        
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getJSONArray("courses").length() > 1) {
                System.out.println(jsonArray.getJSONObject(i).get("name"));
            }
            
        }
    }

    public static void main(String[] arguments) throws ClientProtocolException, IOException, JSONException {
        getStudentsWithMoreThanOneCourse("https://hackbulgaria.com/api/students/");
    }
}