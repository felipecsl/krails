package kales

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.h2.H2DatabasePlugin
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.postgres.PostgresPlugin

object JdbiFactory {
  fun fromConnectionString(connString: String): Jdbi {
    return Jdbi.create(connString)
        .registerColumnMapper(CollectionModelAssociationColumnMapperFactory())
        .registerColumnMapper(SingleModelAssociationColumnMapperFactory())
        .installPlugin(PostgresPlugin())
        .installPlugin(H2DatabasePlugin())
        .installPlugin(KotlinPlugin())
  }
}