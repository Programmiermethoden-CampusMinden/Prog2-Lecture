FROM ubuntu:latest

ENV DEBIAN_FRONTEND noninteractive
RUN apt-get -q --no-allow-insecure-repositories update          \
    && apt-get install --assume-yes --no-install-recommends     \
        openjdk-17-jdk                                          \
        maven                                                   \
        ant                                                     \
        ivy                                                     \
    && rm -rf /var/lib/apt/lists/*

ENTRYPOINT ["sh", "-c"]
