/*
 * Copyright © 2018 Christian Kaltepoth
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package org.mvcspec.tck.tests.mvc.response;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

@Controller
@Path("response")
public class ResponseFeaturesController {

    @GET
    @Path("header")
    public Response header() {
        return Response.ok("view.jsp")
                .header("X-Controller-Header", "Foobar")
                .build();
    }

    @GET
    @Path("cache")
    public Response cache() {

        CacheControl cacheControl = new CacheControl();
        cacheControl.setPrivate(true);

        return Response.ok("view.jsp")
                .cacheControl(cacheControl)
                .build();

    }

}
