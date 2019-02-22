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
import java.util.List;
import org.cactoos.Text;
import org.cactoos.collection.Filtered;
import org.cactoos.list.ListOf;
import org.cactoos.text.TextOf;

/**
 * Issue.
 *
 * @author Filipe Freire (livrofubia@gmail.com)
 * @version $Id: ??? $
 * @since 1.0
 */
public final class Issue {

    /**
     * Issue number.
     */
    private final Integer number;

    /**
     * List of comments.
     */
    private final List<Comment> comments;

    /**
     * Ctor.
     *
     * @param number Issue number
     * @param comments Comment list
     */
    public Issue(final Integer number, final List<Comment> comments) {
        this.number = number;
        this.comments = comments;
    }

    /**
     * List of comments filtered by criteria.
     *
     * @param user User
     * @param text Text of comment's body
     * @return List of Comment
     */
    public List<Comment> commentsByCriteria(final User user, final Text text) {
        return new ListOf<>(
            new Filtered<>(
                this.comments,
                comment -> comment.contains(text) && comment.userIs(user)
            )
        );
    }

    /**
     * Returns issue's number.
     *
     * @return Integer
     */
    public Integer issueNumber() {
        return this.number;
    }

    /**
     * List of comments filtered by criteria.
     *
     * @param user User
     * @param text String text of comment's body
     * @return List of Comment
     */
    public List<Comment> commentsByCriteria(final User user,
        final String text) {
        return this.commentsByCriteria(user, new TextOf(text));
    }
}
