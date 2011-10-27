/*
 * $Id: ExpressionFactoryFactory.java 654222 2008-05-07 19:17:15Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.tiles.evaluator.el;

import javax.el.ExpressionFactory;

/**
 * Interface to define a factory of {@link ExpressionFactory}.
 *
 * @version $Rev: 654222 $ $Date: 2008-05-07 21:17:15 +0200 (Wed, 07 May 2008) $
 * @since 2.1.0
 */
public interface ExpressionFactoryFactory {

    /**
     * Returns the expression factory to use.
     *
     * @return The expression factory.
     * @since 2.1.0
     */
    ExpressionFactory getExpressionFactory();
}
