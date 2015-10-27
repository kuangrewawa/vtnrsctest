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
package org.onosproject.app.vtnrsc.tenantnetwork;

import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import org.junit.Test;
import org.onosproject.app.vtnrsc.DefaultTenantNetwork;
import org.onosproject.app.vtnrsc.PhysicalNetwork;
import org.onosproject.app.vtnrsc.SegmentationId;
import org.onosproject.app.vtnrsc.TenantId;
import org.onosproject.app.vtnrsc.TenantNetwork;
import org.onosproject.app.vtnrsc.TenantNetworkId;

import com.google.common.testing.EqualsTester;

/**
 * Unit tests for DefaultNeutronNetwork class.
 */
public class DefaultNeutronNetworkTest {

    /**
     * Checks that the DefaultNeutronNetwork class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(DefaultTenantNetwork.class);
    }

    /**
     * Checks the operation of equals() methods.
     */
    @Test
    public void testEquality() {
        TenantNetworkId networkid1 = TenantNetworkId.networkId("123");
        TenantNetworkId networkid2 = TenantNetworkId.networkId("321");
        PhysicalNetwork physicalNetwork = PhysicalNetwork.physicalNetwork("234");
        TenantId tenantId = TenantId.tenantId("345");
        SegmentationId segmentationID = SegmentationId.segmentationId("456");
        String name = "name";
        TenantNetwork p1 = new DefaultTenantNetwork(networkid1, name, false,
                                                    TenantNetwork.State.ACTIVE, false, tenantId,
                                                    false, TenantNetwork.Type.LOCAL,
                                                    physicalNetwork, segmentationID);
        TenantNetwork p2 = new DefaultTenantNetwork(networkid1, name, false,
                                                    TenantNetwork.State.ACTIVE, false, tenantId,
                                                    false, TenantNetwork.Type.LOCAL,
                                                    physicalNetwork, segmentationID);
        TenantNetwork p3 = new DefaultTenantNetwork(networkid2, name, false,
                                                    TenantNetwork.State.ACTIVE, false, tenantId,
                                                    false, TenantNetwork.Type.LOCAL,
                                                    physicalNetwork, segmentationID);
        new EqualsTester().addEqualityGroup(p1, p2).addEqualityGroup(p3).testEquals();
    }
}
