package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); //일반적인 java 객체 호출이 아닌 DB에 있는 class, 즉 객체라는 하나의 entity, 앤티티를 가져오는 방식 중 한가지가 findBy?
    List<Member> findAll();
}
