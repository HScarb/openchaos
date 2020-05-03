/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.openmessaging.chaos.driver.rocketmq;

import io.openmessaging.chaos.driver.mq.MQChaosPushConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RocketMQChaosPushConsumer implements MQChaosPushConsumer {

    private static final Logger log = LoggerFactory.getLogger(RocketMQChaosPushConsumer.class);
    private DefaultMQPushConsumer defaultMQPushConsumer;

    public RocketMQChaosPushConsumer(DefaultMQPushConsumer defaultMQPushConsumer) {
        this.defaultMQPushConsumer = defaultMQPushConsumer;
    }

    @Override public void start() {
        try {
            if (defaultMQPushConsumer != null) {
                defaultMQPushConsumer.start();
            }
        } catch (MQClientException e) {
            log.error("Failed to start the RocketMQChaosPullConsumer instance.", e);
        }
    }

    @Override public void close() {
        if (defaultMQPushConsumer != null) {
            defaultMQPushConsumer.shutdown();
        }
    }
}
