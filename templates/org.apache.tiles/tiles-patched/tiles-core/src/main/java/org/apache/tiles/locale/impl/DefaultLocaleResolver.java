/*
 * $Id: DefaultLocaleResolver.java 637434 2008-03-15 15:48:38Z apetrelli $
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
package org.apache.tiles.locale.impl;

import java.util.Locale;
import java.util.Map;

import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.locale.LocaleResolver;

/**
 * Default implementation of <code>LocaleResolver</code><br>
 * It tries to take the locale from the session-scoped attribute
 * {@link DefaultLocaleResolver#LOCALE_KEY}. If it is not found, it returns the
 * locale included in the request.
 *
 * @version $Rev: 637434 $ $Date: 2008-03-15 16:48:38 +0100 (Sat, 15 Mar 2008) $
 */
public class DefaultLocaleResolver implements LocaleResolver {

    /**
     * The attribute name that is used to store the current locale.
     */
    public static final String LOCALE_KEY = "org.apache.tiles.LOCALE";

    /** {@inheritDoc} */
    public void init(Map<String, String> params) {
        // Does nothing.
    }

    /** {@inheritDoc} */
    public Locale resolveLocale(TilesRequestContext request) {
        Locale retValue = null;
        Map<String, Object> session = request.getSessionScope();
        if (session != null) {
            retValue = (Locale) session.get(DefaultLocaleResolver.LOCALE_KEY);
        }
        if (retValue == null) {
            retValue = request.getRequestLocale();
        }

        return retValue;
    }
}
