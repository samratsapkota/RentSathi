package com.rent.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRent is a Querydsl query type for Rent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRent extends EntityPathBase<Rent> {

    private static final long serialVersionUID = -109145498L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRent rent = new QRent("rent");

    public final DatePath<java.sql.Date> createdAt = createDate("createdAt", java.sql.Date.class);

    public final QUser createdBy;

    public final DatePath<java.sql.Date> deletedAt = createDate("deletedAt", java.sql.Date.class);

    public final StringPath description = createString("description");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath imageName = createString("imageName");

    public final ArrayPath<byte[], Byte> imagePath = createArray("imagePath", byte[].class);

    public final StringPath location = createString("location");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath PropertySpecification = createString("PropertySpecification");

    public final StringPath rentType = createString("rentType");

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public final StringPath title = createString("title");

    public final DatePath<java.sql.Date> updatedAt = createDate("updatedAt", java.sql.Date.class);

    public final QUser updatedBy;

    public QRent(String variable) {
        this(Rent.class, forVariable(variable), INITS);
    }

    public QRent(Path<? extends Rent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRent(PathMetadata metadata, PathInits inits) {
        this(Rent.class, metadata, inits);
    }

    public QRent(Class<? extends Rent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new QUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
    }

}

