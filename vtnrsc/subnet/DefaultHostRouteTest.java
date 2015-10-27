/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.app.vtnrsc.subnet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import org.junit.Test;
import org.onlab.packet.IpAddress;
import org.onlab.packet.IpPrefix;
import org.onosproject.app.vtnrsc.DefaultHostRoute;
import org.onosproject.app.vtnrsc.HostRoute;

import com.google.common.testing.EqualsTester;

/**
 * Unit tests for DefaultHostRoute class.
 */
public class DefaultHostRouteTest {
    final IpAddress nexthop1 = IpAddress.valueOf("192.168.1.1");
    final IpAddress nexthop2 = IpAddress.valueOf("192.168.1.2");
    final IpPrefix destination1 = IpPrefix.valueOf("1.1.1.1/1");
    final IpPrefix destination2 = IpPrefix.valueOf("1.1.1.1/2");

    /**
     * Checks that the DefaultHostRoute class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(DefaultHostRoute.class);
    }

    /**
     * Checks the operation of equals() methods.
     */
    @Test
    public void testEquals() {
        new EqualsTester().addEqualityGroup(new DefaultHostRoute(nexthop1, destination1))
                .addEqualityGroup(new DefaultHostRoute(nexthop2, destination2)).testEquals();
    }

    /**
     * Checks the construction of a host object.
     */
    @Test
    public void testConstruction() {
        final HostRoute host = new DefaultHostRoute(nexthop1, destination1);
        assertThat(nexthop1, is(host.nexthop()));
    }
}
