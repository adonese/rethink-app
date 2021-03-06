/*
Copyright 2020 RethinkDNS developers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.celzero.bravedns.database

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BlockedConnectionsRepository(private val blockedConnectionsDAO: BlockedConnectionsDAO) {

    fun updateAsync(blockedConnections: BlockedConnections) {
        blockedConnectionsDAO.update(blockedConnections)
    }

    fun deleteAsync(blockedConnections: BlockedConnections) {
        blockedConnectionsDAO.delete(blockedConnections)
    }

    fun clearFirewallRules(uid: Int, coroutineScope: CoroutineScope = GlobalScope) {
        //coroutineScope.launch {
            blockedConnectionsDAO.clearFirewallRules(uid)
        //}
    }

    fun insertAsync(blockedConnections: BlockedConnections, coroutineScope: CoroutineScope = GlobalScope) {
        //coroutineScope.launch {
            blockedConnectionsDAO.insert(blockedConnections)
        //}
    }

    fun getBlockedConnections(): List<BlockedConnections> {
        return blockedConnectionsDAO.getBlockedConnections()
    }

    fun getAllBlockedConnectionsForUID(uid: Int): List<BlockedConnections> {
        return blockedConnectionsDAO.getAllBlockedConnectionsForUID(uid)
    }

    fun deleteIPRulesUniversal(ipAddress: String, coroutineScope: CoroutineScope = GlobalScope) {
        //coroutineScope.launch {
            blockedConnectionsDAO.deleteIPRulesUniversal(ipAddress)
        //}
    }

    fun deleteIPRulesForUID(uid: Int, ipAddress: String, coroutineScope: CoroutineScope = GlobalScope) {
        //coroutineScope.launch {
            blockedConnectionsDAO.deleteIPRulesForUID(uid, ipAddress)
        //}
    }

    fun deleteAllIPRulesUniversal(coroutineScope: CoroutineScope = GlobalScope) {
        coroutineScope.launch {
            blockedConnectionsDAO.deleteAllIPRulesUniversal()
        }
    }

    fun getBlockedConnectionsCount(): Int{
        return blockedConnectionsDAO.getBlockedConnectionsCount()
    }


    //fun deleteRules(uid, )
}