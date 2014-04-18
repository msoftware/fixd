/*
 * Copyright (C) 2013 BigTesting.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bigtesting.fixd.response.impl;

import java.io.InputStream;

import org.bigtesting.fixd.core.ByteArrayResponseBody;
import org.bigtesting.fixd.core.InputStreamResponseBody;
import org.bigtesting.fixd.core.InterpretedResponseBody;
import org.bigtesting.fixd.core.ResponseBody;
import org.bigtesting.fixd.core.StringResponseBody;
import org.bigtesting.fixd.request.HttpRequest;
import org.bigtesting.fixd.response.HttpResponse;

/**
 * 
 * @author Luis Antunes
 */
public class SimpleHttpResponse implements HttpResponse {

    private final HttpRequest request;
    
    private ResponseBody body;
    private String contentType;
    private int statusCode;
    
    public SimpleHttpResponse(HttpRequest req) {
        this.request = req;
    }
    
    public void setBody(InputStream in) {
        this.body = new InputStreamResponseBody(in);
    }

    public void setBody(byte[] content) {
        this.body = new ByteArrayResponseBody(content);
    }

    public void setBody(String content) {
        this.body = new StringResponseBody(content);
    }

    public void setInterpretedBody(String content) {
        this.body = new InterpretedResponseBody(content, request);
    }
    
    public ResponseBody getBody() {
        return body;
    }
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
    
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
