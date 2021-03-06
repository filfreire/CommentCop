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
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Tests for ${@link Comment}.
 *
 * @since 1.0
 */
public final class CommentTest {

    /**
     * Checks comment id.
     * @throws Exception In case of error
     */
    @Test
    public void checksCommentId() throws Exception {
        final User user = new User("user");
        final int number = 123;
        final Comment comment = new Comment(number, "comment text", user);
        Assertions.assertThat(comment.idIs(number)).isTrue();
    }

    /**
     * Checks comment user.
     * @throws Exception In case of error
     */
    @Test
    public void checksCommentUser() throws Exception {
        final User user = new User("filfreire");
        final Comment comment = new Comment(1, "Just a comment.", user);
        Assertions.assertThat(comment.userIs(user)).isTrue();
    }

    /**
     * Checks comment contains.
     * @throws Exception In case of error
     */
    @Test
    public void checksCommentContains() throws Exception {
        final User user = new User("octocat");
        final Comment comment = new Comment(1, "Another a comment.", user);
        Assertions.assertThat(comment.contains("comment")).isTrue();
        Assertions.assertThat(comment.contains("bugs bunny")).isFalse();
    }
}
