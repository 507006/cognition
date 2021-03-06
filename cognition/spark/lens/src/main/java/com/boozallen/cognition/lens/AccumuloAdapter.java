/*
 * Licensed to Booz Allen Hamilton under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Booz Allen Hamilton licenses this file to you
 * under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

package com.boozallen.cognition.lens;

import com.boozallen.cognition.accumulo.config.AccumuloConfiguration;
import com.boozallen.cognition.accumulo.config.CognitionConfiguration;
import com.boozallen.cognition.accumulo.structure.AccumuloUtils;

public class AccumuloAdapter {

  /**
   * Add information to the accumulo configuration
   * @param criteria -- the criteria object to pull the necessary information from
   * @param cognition -- the current cognition configuration
   * @return a fully configured accumulo configuration
   */
  public static AccumuloConfiguration getAccumuloConfiguration(Criteria criteria, CognitionConfiguration cognition) {
    AccumuloConfiguration accumulo = cognition.getAccumuloConfiguration();
    accumulo.setTableName(criteria.getAccumuloTable());
    accumulo.setRanges(AccumuloUtils.getRanges(criteria.getDateStart(), criteria.getDateEnd(), criteria.getSource()));
    accumulo.setAuthorizations(criteria.getSchema().getAuthorizations());

    return accumulo;
  }

}
