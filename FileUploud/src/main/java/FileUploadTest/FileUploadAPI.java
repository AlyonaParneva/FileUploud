package FileUploadTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class FileUploadAPI {

    public String uploadFile(String filePath) {
        try {
            CloseableHttpClient httpClient = HttpsClientFactory.createHttpClient();  // Using the factory

            HttpPost uploadFile = new HttpPost("https://api32o.ilovepdf.com/v1/upload");
            File file = new File(filePath);
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", file)
                    .build();
            uploadFile.setEntity(entity);

            HttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                httpClient.close();
                return responseString;
            }

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}