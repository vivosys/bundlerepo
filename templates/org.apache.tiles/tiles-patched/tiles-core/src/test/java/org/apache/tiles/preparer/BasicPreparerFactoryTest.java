/*
 * $Id: BasicPreparerFactoryTest.java 637434 2008-03-15 15:48:38Z apetrelli $
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
package org.apache.tiles.preparer;

import junit.framework.TestCase;

/**
 * Tests the basic preparer factory.
 *
 * @version $Rev: 637434 $ $Date: 2008-03-15 16:48:38 +0100 (Sat, 15 Mar 2008) $
 */
public class BasicPreparerFactoryTest extends TestCase {

    /**
     * The preparer factory.
     */
    private BasicPreparerFactory factory;

    /** {@inheritDoc} */
    @Override
    public void setUp() {
        factory = new BasicPreparerFactory();
    }

    /**
     * Tests getting a preparer.
     */
    public void testGetPreparer() {
        String name = ViewPreparerSupport.class.getName();
        ViewPreparer p = factory.getPreparer(name, null);
        assertNotNull(p);
        assertTrue(p instanceof ViewPreparerSupport);

        name = "org.doesnotexist.Class";
        p = factory.getPreparer(name, null);
        assertNull(p);
    }
}
