package se.hallindesign.tradedesigner.repository.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import se.hallindesign.tradedesigner.domain.User;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {}
