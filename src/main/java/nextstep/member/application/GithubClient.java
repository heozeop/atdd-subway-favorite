package nextstep.member.application;

import nextstep.member.application.dto.GithubAccessTokenRequest;
import nextstep.member.application.dto.GithubAccessTokenResponse;
import nextstep.member.application.dto.GithubProfileResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties
@ConfigurationPropertiesScan
public class GithubClient {
    @Value("${github.client.id}")
    private String githubClientId;

    @Value("${github.client.secret}")
    private String githubClientSecret;

    @Value("${github.client.access-token-url}")
    private String accessTokenUrl = "http://localhost:8080/github/login/oauth/access_token";

    @Value("${github.client.profile-url}")
    private String profileUrl = "http://localhost:8080/github/user";

    public String requestGithubToken(String code) {
        GithubAccessTokenRequest githubAccessTokenRequest = new GithubAccessTokenRequest(
            code,
            githubClientId,
            githubClientSecret
        );

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(
            githubAccessTokenRequest, headers);
        RestTemplate restTemplate = new RestTemplate();

        String accessToken = restTemplate
            .exchange(accessTokenUrl, HttpMethod.POST, httpEntity, GithubAccessTokenResponse.class)
            .getBody()
            .getAccessToken();

        return accessToken;
    }

    public GithubProfileResponse requestGithubProfile(String accessToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearer " + accessToken);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        final HttpEntity httpEntity = new HttpEntity(headers);

        final RestTemplate restTemplate = new RestTemplate();

        return restTemplate
            .exchange(profileUrl, HttpMethod.GET, httpEntity, GithubProfileResponse.class)
            .getBody();
    }
}
