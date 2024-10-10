package FileUploadTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class FileUploadAPI {
    private final String authUrl = "https://api.ilovepdf.com/v1/auth";
    private final String uploadUrl = "https://api.ilovepdf.com/v1/upload";
    private String publicKey;

    public FileUploadAPI(String publicKey) {
        this.publicKey = publicKey;
    }

    public boolean authenticate() {
        try (CloseableHttpClient client = HttpsClientFactory.createHttpClient()) {
            HttpPost httpPost = new HttpPost(authUrl);

            String authPayload = "{\"public_key\": \"" + publicKey + "\"}";
            httpPost.setEntity(new StringEntity(authPayload));
            httpPost.setHeader("Content-Type", "application/json");

            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            System.out.println("Auth status code: " + statusCode);
            System.out.println("Auth response: " + responseBody);

            return (statusCode == 200);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public String uploadFile(String filePath) {
        return "File upload functionality not implemented.";
    }
}