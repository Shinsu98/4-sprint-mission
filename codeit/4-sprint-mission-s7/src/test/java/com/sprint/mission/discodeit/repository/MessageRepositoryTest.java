package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.JpaAuditingTestConfig;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.fixture.ChannelFixture;
import com.sprint.mission.discodeit.fixture.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import({JpaAuditingTestConfig.class})
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChannelRepository channelRepository;

    @BeforeEach
    void setUp() {
        messageRepository.deleteAll();
        User user = UserFixture.createUserKim();
        Channel channel = ChannelFixture.createPublicChannel();

        userRepository.save(user);
        channelRepository.save(channel);

        Message message1 = new Message("첫 번째 메시지", channel, user, null);
        messageRepository.save(message1);

        Message message2 = new Message("두 번째 메시지", channel, user, null);
        messageRepository.save(message2);

        Message message3 = new Message("세 번째 메시지", channel, user, null);
        messageRepository.save(message3);
    }

}
