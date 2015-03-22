/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.egreen.seed.impl.config.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum DeploymentModeEnum {
    triggered,
    scheduled;

    public String value() {
        return name();
    }

    public static DeploymentModeEnum fromValue(String v) {
        return valueOf(v);
    }
}
