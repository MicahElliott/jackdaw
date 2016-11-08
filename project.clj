(defproject fundingcircle/kafka.serdes "0.4.2"
  :description "Serializers/deserializers for Kafka"
  :url "https://github.com/FundingCircle/kafka-serdes"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :local-repo ".repo"
  :aot :all
  :dependencies [[environ "1.1.0"]
                 [inflections "0.12.2"]
                 [io.confluent/kafka-avro-serializer "3.0.0"]
                 [io.confluent/kafka-schema-registry-client "3.0.0"]
                 [org.apache.kafka/kafka-clients "0.10.0.0-cp1"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/test.check "0.9.0"]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :repositories  {"confluent" {:url "http://packages.confluent.io/maven/"}
                  "snapshots" {:url "https://fundingcircle.artifactoryonline.com/fundingcircle/libs-snapshot-local"
                               :username [:gpg :env/artifactory_user]
                               :password [:gpg :env/artifactory_password]
                               :sign-releases false}
                  "releases" {:url "https://fundingcircle.artifactoryonline.com/fundingcircle/libs-release-local"
                              :username [:gpg :env/artifactory_user]
                              :password [:gpg :env/artifactory_password]
                              :sign-releases false}})
