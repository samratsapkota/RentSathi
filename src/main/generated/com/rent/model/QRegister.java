package com.rent.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegister is a Querydsl query type for Register
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegister extends EntityPathBase<Register> {

    private static final long serialVersionUID = 220989264L;

    public static final QRegister register = new QRegister("register");

    public final StringPath addressType = createString("addressType");

    public final StringPath city = createString("city");

    public final DateTimePath<java.sql.Timestamp> createdAt = createDateTime("createdAt", java.sql.Timestamp.class);

    public final StringPath district = createString("district");

    public final DateTimePath<java.util.Date> dob = createDateTime("dob", java.util.Date.class);

    public final StringPath email = createString("email");

    public final StringPath fullname = createString("fullname");

    public final StringPath gender = createString("gender");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Integer> idNo = createNumber("idNo", Integer.class);

    public final StringPath idType = createString("idType");

    public final StringPath IssuedAuthority = createString("IssuedAuthority");

    public final NumberPath<Long> mobileno = createNumber("mobileno", Long.class);

    public final StringPath occupation = createString("occupation");

    public final StringPath password = createString("password");

    public final StringPath province = createString("province");

    public QRegister(String variable) {
        super(Register.class, forVariable(variable));
    }

    public QRegister(Path<? extends Register> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegister(PathMetadata metadata) {
        super(Register.class, metadata);
    }

}

