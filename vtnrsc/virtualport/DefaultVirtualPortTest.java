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

import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

import org.junit.Test;
import org.onlab.packet.IpAddress;
import org.onlab.packet.MacAddress;
import org.onosproject.app.vtnrsc.AllowedAddressPair;
import org.onosproject.app.vtnrsc.DefaultVirtualPort;
import org.onosproject.app.vtnrsc.FixedIp;
import org.onosproject.app.vtnrsc.SecurityGroup;
import org.onosproject.app.vtnrsc.SubnetId;
import org.onosproject.app.vtnrsc.TenantId;
import org.onosproject.app.vtnrsc.TenantNetworkId;
import org.onosproject.app.vtnrsc.VirtualPort;
import org.onosproject.app.vtnrsc.VirtualPortId;
import org.onosproject.net.DeviceId;
import org.onosproject.net.HostId;

import com.google.common.collect.Maps;
import com.google.common.testing.EqualsTester;

/**
 * Unit tests for DefaultVirtualPort class.
 */
public class DefaultVirtualPortTest {

    final SecurityGroup securityGroup1 = SecurityGroup.securityGroup("1");
    final SecurityGroup sameAssecurityGroup = SecurityGroup.securityGroup("1");
    final SecurityGroup securityGroup2 = SecurityGroup.securityGroup("2");

    /**
     * Checks that the DefaultVirtualPort class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(SecurityGroup.class);
    }

    /**
     * Checks the operation of equals().
     */
    @Test
    public void testEquals() {
        VirtualPortId id1 = VirtualPortId.portId("111");
        VirtualPortId id2 = VirtualPortId.portId("222");
        TenantNetworkId networkId = TenantNetworkId.networkId("222");
        String name = "aaa";
        MacAddress macAddress = MacAddress.valueOf("fa:12:3e:56:ee:a2");
        TenantId tenantId = TenantId.tenantId("333");
        DeviceId deviceId = DeviceId.deviceId("444");
        String deviceOwner = "james";
        FixedIp fixedIp = FixedIp.fixedIp(SubnetId.subnetId("121"), IpAddress.valueOf("10.1.1.1"));
        HostId bindingHostId = HostId.hostId(MacAddress.valueOf("fa:e2:3e:56:ee:a2"));
        String bindingvnicType = "normal";
        String bindingvifType = "ovs";
        String bindingvnicDetails = "aaaa";
        Collection<AllowedAddressPair> allowedAddressPairs = new ArrayList<AllowedAddressPair>();
        AllowedAddressPair allowedAddressPair = AllowedAddressPair.allowedAddressPair(IpAddress
                .valueOf("192.168.1.2"), MacAddress.valueOf("aa:1e:3e:4a:aa:ee"));
        allowedAddressPairs.add(allowedAddressPair);
        Collection<SecurityGroup> securityGroups = new ArrayList<SecurityGroup>();
        SecurityGroup securityGroup = SecurityGroup.securityGroup("aaaa-123a-a3334-df34-111");
        securityGroups.add(securityGroup);
        ConcurrentMap<String, String> strMap = Maps.newConcurrentMap();
        strMap.putIfAbsent("name", name);
        strMap.putIfAbsent("deviceOwner", deviceOwner);
        strMap.putIfAbsent("bindingvnicType", bindingvnicType);
        strMap.putIfAbsent("bindingvifType", bindingvifType);
        strMap.putIfAbsent("bindingvnicDetails", bindingvnicDetails);
        DefaultVirtualPort d1 = new DefaultVirtualPort(id1, networkId, true, strMap,
                                                       VirtualPort.State.ACTIVE, macAddress,
                                                       tenantId, deviceId, fixedIp, bindingHostId,
                                                       allowedAddressPairs, securityGroups);
        DefaultVirtualPort d2 = new DefaultVirtualPort(id1, networkId, true, strMap,
                                                       VirtualPort.State.ACTIVE, macAddress,
                                                       tenantId, deviceId, fixedIp, bindingHostId,
                                                       allowedAddressPairs, securityGroups);
        DefaultVirtualPort d3 = new DefaultVirtualPort(id2, networkId, true, strMap,
                                                       VirtualPort.State.ACTIVE, macAddress,
                                                       tenantId, deviceId, fixedIp, bindingHostId,
                                                       allowedAddressPairs, securityGroups);
        new EqualsTester().addEqualityGroup(d1, d2).addEqualityGroup(d3).testEquals();
    }
}
