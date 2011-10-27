/*
 * $Id: AbstractTilesApplicationContextFactoryAware.java 722063 2008-12-01 13:10:11Z apetrelli $
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
package org.apache.tiles.awareness;

import org.apache.tiles.context.AbstractTilesApplicationContextFactory;

/**
 * It represents an object that can have a reference to the
 * {@link AbstractTilesApplicationContextFactoryAware}.
 *
 * @version $Rev: 722063 $ $Date: 2008-12-01 14:10:11 +0100 (Mon, 01 Dec 2008) $
 * @since 2.1.1
 */
public interface AbstractTilesApplicationContextFactoryAware {

    /**
     * Sets the Tiles application context factory.
     *
     * @param contextFactory The Tiles context factory.
     * @since 2.1.1
     */
    void setApplicationContextFactory(
            AbstractTilesApplicationContextFactory contextFactory);
}
