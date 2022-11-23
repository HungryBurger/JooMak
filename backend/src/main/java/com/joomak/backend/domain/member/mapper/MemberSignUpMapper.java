package com.joomak.backend.domain.member.mapper;

import com.joomak.backend.domain.member.dto.MemberSignUpDto;
import com.joomak.backend.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MemberSignUpMapper {
    MemberSignUpDto toMemberSignUpDto(Member member);
    Member toMemberEntity(MemberSignUpDto memberSignUpDto);
}
