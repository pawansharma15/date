package com.futurice.date;

import com.alibaba.fastjson.JSONObject;

public class View {
    public JSONObject createSuccessResponse(Integer days) {
        return new JSONObject()
                .fluentPut("error", false)
                .fluentPut("result", days);
    }

    public JSONObject createErrorResponse(String errors) {
        return new JSONObject()
                .fluentPut("error", true)
                .fluentPut("message", errors);
    }
}
