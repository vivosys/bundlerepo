/*
 * $Id: TestViewPreparer.java 646533 2008-04-09 21:04:48Z apetrelli $
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
package org.apache.tiles.test.preparer;

import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.Attribute;

/**
 * A simple test <code>ViewPreparer</code>.
 *
 * @version $Rev: 646533 $ $Date: 2008-04-09 23:04:48 +0200 (Wed, 09 Apr 2008) $
 */
public class TestViewPreparer implements ViewPreparer {

    /** {@inheritDoc} */
    public void execute(TilesRequestContext tilesContext,
            AttributeContext attributeContext) {
        attributeContext.putAttribute(
            "body",
            new Attribute("This is the value added by the ViewPreparer"));
    }
}
