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
import java.util.List;
import org.assertj.core.api.Assertions;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.JoinedText;
import org.cactoos.text.TextOf;
import org.junit.Test;

/**
 * Tests for ${@link JsonComment}.
 *
 * @since 1.0
 */
public final class JsonCommentsTest {

    /**
     * Checks list of comments.
     * @throws Exception In case of error
     */
    @Test
    public void checkListOfComments() throws Exception {
        final Text json = new TextOf(
            new JoinedText(
                "",
                "[{\"id\":1,\"body\":\"Me\",\"user\":{\"login\":\"octo\"}},",
                "{\"id\":2,\"body\":\"Em\",\"user\":{\"login\":\"cat\"}}]"
            ).asString()
        );
        final List<Comment> expected = new ListOf<>(
            new Comment(
                1,
                "Me",
                new User("octo")
            ),
            new Comment(
                2,
                "Em",
                new User("cat")
            )
        );
        final List<Comment> comments = new JsonComments(json).asComments();
        Assertions.assertThat(comments).hasSameSizeAs(expected);
        Assertions.assertThat(comments.get(0))
            .isEqualToComparingFieldByFieldRecursively(expected.get(0));
        Assertions.assertThat(comments.get(1))
            .isEqualToComparingFieldByFieldRecursively(expected.get(1));
    }

    /**
     * Checks list of comments given empty str.
     * @throws Exception In case of error
     */
    @Test
    public void checkListOfCommentsGivenEmptyString() throws Exception {
        Assertions.assertThatThrownBy(
            () -> new JsonComments(new TextOf("")).asComments()
        ).isInstanceOf(Exception.class)
        .hasMessageContaining("No content to map");
    }
}
