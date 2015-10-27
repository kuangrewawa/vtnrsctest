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

package org.onosproject.app.vtnrsc.virtualport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import org.junit.Test;
import org.onlab.packet.IpAddress;
import org.onosproject.app.vtnrsc.FixedIp;
import org.onosproject.app.vtnrsc.SubnetId;

import com.google.common.testing.EqualsTester;

/**
 * Unit tests for FixedIp class.
 */
public class FixedIpTest {

    final SubnetId subnetId1 = SubnetId.subnetId("lef11-95w-4er-9c9c");
    final SubnetId subnetId2 = SubnetId.subnetId("lefaa-95w-4er-9c9c");
    final IpAddress ip1 = IpAddress.valueOf("192.168.0.1");
    final IpAddress ip2 = IpAddress.valueOf("192.168.1.1");

    /**
     * Checks that the AllowedAddressPair class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(FixedIp.class);
    }

    /**
     * Checks the operation of equals().
     */
    @Test
    public void testEquals() {
        new EqualsTester().addEqualityGroup(FixedIp.fixedIp(subnetId1, ip1))
                .addEqualityGroup(FixedIp.fixedIp(subnetId2, ip2)).testEquals();
    }

    /**
     * Checks the construction of a FixedIp object.
     */
    @Test
    public void testConstruction() {
        FixedIp fixedIp = FixedIp.fixedIp(subnetId1, ip1);
        assertThat(ip1, is(notNullValue()));
        assertThat(ip1, is(fixedIp.ip()));
        assertThat(subnetId1, is(notNullValue()));
        assertThat(subnetId1, is(fixedIp.subnetId()));
    }
}
