/**
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
import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.cactoos.list.ListOf;
import org.junit.Test;

/**
 * Tests for ${@link Issue}.
 *
 * @author Filipe Freire (livrofubia@gmail.com)
 * @version $Id: ??? $
 * @since 1.0
 */
public final class IssueTest {

    /**
     * Returns issue number.
     * @throws Exception In case of error
     */
    @Test
    public void returnsIssueNumber() throws Exception {
        final int number = 123;
        final Issue issue = new Issue(number, new LinkedList<>());
        Assertions.assertThat(issue.issueNumber()).isEqualTo(number);
    }

    /**
     * Returns comments by criteria.
     * @throws Exception In case of error
     */
    @Test
    public void returnsCommentsByCriteria() throws Exception {
        final User user = new User("filfreire");
        final User otheruser = new User("octocat");
        final List<Comment> comments = new ListOf<>(
            new Comment(1, "comment 1", user),
            new Comment(2, "find me!!", user),
            new Comment(3, "comment 3", otheruser)
        );
        final Issue issue = new Issue(1, comments);
        Assertions.assertThat(
            issue.commentsByCriteria(user, "find").size()
        ).isEqualTo(1);
        Assertions.assertThat(
            issue.commentsByCriteria(otheruser, "comment").size()
        ).isEqualTo(1);
        Assertions.assertThat(
            issue.commentsByCriteria(user, "e").size()
        ).isEqualTo(2);
    }

}
