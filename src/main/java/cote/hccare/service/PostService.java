package cote.hccare.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cote.hccare.domain.PostRequest;
import cote.hccare.domain.PostResponse;
import cote.hccare.domain.ToastUiResponse;
import cote.hccare.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class PostService {

    private PostMapper postMapper;

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public ToastUiResponse findPosts() {
        List<PostResponse> posts = postMapper.findAll();
        // 게시판 데이터를 가져와서 Thymeleaf 템플릿으로 전달
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("contents", posts);
        resultMap.put("pagination", "");

        return ToastUiResponse.builder().result(true).data(resultMap).build();
    }

    public void createPosts(HashMap<String, Object> createdRows) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonData = objectMapper.writeValueAsString(createdRows);

            JsonNode rootNode = objectMapper.readTree(jsonData).get("createdRows");

            String title, content, author;
            PostRequest postRequest = new PostRequest();
            for (int i = 0; i < rootNode.size(); i++) {
                title = rootNode.get(i).get("title").asText();
                content = rootNode.get(i).get("content").asText();
                author = rootNode.get(i).get("author").asText();

                postRequest.setTitle(title);
                postRequest.setContent(content);
                postRequest.setAuthor(author);

                postMapper.save(postRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePosts(HashMap<String, Object> updatedRows) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonData = objectMapper.writeValueAsString(updatedRows);

            JsonNode rootNode = objectMapper.readTree(jsonData).get("updatedRows");

            String title, content, author;
            Long id;
            PostRequest postRequest = new PostRequest();
            for (int i = 0; i < rootNode.size(); i++) {
                id = rootNode.get(i).get("id").asLong();
                title = rootNode.get(i).get("title").asText();
                content = rootNode.get(i).get("content").asText();
                author = rootNode.get(i).get("author").asText();

                postRequest.setId(id);
                postRequest.setTitle(title);
                postRequest.setContent(content);
                postRequest.setAuthor(author);

                postMapper.update(postRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePost(Long id) {
        postMapper.deleteById(id);
    }

}
