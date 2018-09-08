/**
 * Copyright (c) 2017-2018 Filipe Freire
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
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.junit.Test;

/**
 * Tests for ${@link JsonComment}.
 *
 * @author Filipe Freire (livrofubia@gmail.com)
 * @version $Id: ??? $
 * @since 1.0
 */
public final class JsonCommentTest {

    /**
     * Checks comment id.
     * @throws Exception In case of error
     */
    @Test
    public void checkAsComment() throws Exception {
        final Text json = new TextOf(
            "{\"id\":1,\"body\":\"Me too\",\"user\":{\"login\":\"octocat\"}}"
        );
        final Comment expected = new Comment(
            1,
            "Me too",
            new User("octocat")
        );
        final Comment comment = new JsonComment(json).asComment();
        Assertions.assertThat(comment)
            .isEqualToComparingFieldByFieldRecursively(expected);
    }
}
