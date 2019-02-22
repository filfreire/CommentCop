/*
 * Copyright (c) 2017-2019 Filipe Freire
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.commentcop.repo;

import com.commentcop.api.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.cactoos.Text;

/**
 * Comment.
 *
 * @since 1.0
 */
public final class JsonComment {

    /**
     * Comment json body.
     */
    private final Text json;

    /**
     * Ctor.
     *
     * @param json Comment json body
     */
    public JsonComment(final Text json) {
        this.json = json;
    }

    /**
     * Return as a Comment object.
     *
     * @return Comment
     * @throws IOException On failure
     */
    public Comment asComment() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode node = mapper.readTree(this.json.asString());
        return new Comment(
            node.get("id").asInt(),
            node.get("body").asText(),
            new User(node.get("user").get("login").asText())
        );
    }

}
