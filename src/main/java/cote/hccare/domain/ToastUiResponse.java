package cote.hccare.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToastUiResponse {
    private boolean result;
    private HashMap<String, Object> data;

    @Builder
    ToastUiResponse(boolean result, HashMap<String, Object> data) {
        this.result = result;
        this.data = data;

    }
}
