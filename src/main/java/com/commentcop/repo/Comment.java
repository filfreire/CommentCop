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
import java.io.IOException;
import org.cactoos.Text;
import org.cactoos.text.TextOf;

/**
 * Comment.
 *
 * @since 1.0
 */
public final class Comment {

    /**
     * Comment id.
     */
    private final Integer id;

    /**
     * Comment body.
     */
    private final Text body;

    /**
     * Comment user.
     */
    private final User user;

    /**
     * Ctor.
     *
     * @param id Comment id
     * @param body Comment body
     * @param user User
     */
    public Comment(final Integer id, final Text body, final User user) {
        this.id = id;
        this.body = body;
        this.user = user;
    }

    /**
     * Ctor.
     *
     * @param id Comment id
     * @param body Comment body
     * @param user User
     */
    public Comment(final Integer id, final String body, final User user) {
        this(
            id,
            new TextOf(body),
            user
        );
    }

    /**
     * Check if id is the same.
     *
     * @param value Comment id
     * @return Boolean
     */
    public boolean idIs(final Integer value) {
        return this.id.equals(value);
    }

    /**
     * Compare user.
     *
     * @param value User
     * @return Boolean
     */
    public boolean userIs(final User value) {
        return this.user.compareTo(value);
    }

    /**
     * Body contains text.
     *
     * @param text Body
     * @return Boolean
     * @throws IOException On failure
     */
    public boolean contains(final Text text) throws IOException {
        return this.body.asString().contains(text.asString());
    }

    /**
     * Body contains string text.
     *
     * @param text Body
     * @return Boolean
     * @throws IOException On failure
     */
    public boolean contains(final String text) throws IOException {
        return this.body.asString().contains(text);
    }

}
