package com.evolutiongaming.random

import cats.syntax.all._
import cats.effect.{Clock, Sync}

trait RandomStateOf[F[_]] {
  def apply(): F[Random.State]
}

object RandomStateOf {

  private abstract sealed class Main

  def of[F[_]: Sync: Clock]: F[RandomStateOf[F]] = {
    SeedOf
      .fromClock[F]
      .map { seedOf =>
        new Main with RandomStateOf[F] {
          def apply() = {
            seedOf().map { seed => Random.State(seed) }
          }
        }
      }
  }
}
