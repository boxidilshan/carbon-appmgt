/*
 *
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.appmgt.rest.api.util.validation;

import org.wso2.carbon.appmgt.rest.api.util.validation.constraints.ValidateApiId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApiIdValidator implements ConstraintValidator<ValidateApiId, String> {

    public void initialize(ValidateApiId constraintAnnotation) {
    }

    public boolean isValid(String apiId, ConstraintValidatorContext constraintContext) {
        if (apiId == null) {
            return false;
        } else if (apiId.matches("[\\w.@]+-[\\w.]+-[\\w.]+")) { //matches provider-name-version template
            return true;
        } else if (apiId.toLowerCase().matches(
                "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}")) { // matches UUID format 
            return true;
        }
        return false;
    }
}
