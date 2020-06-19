;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-) Shift + enter evaluates code. Poke the question mark (top right) to learn more ...
;; **

;; @@
(ns test
  (:use gorilla-test.core)
  (:use clojure.repl)
  (:use clojure.pprint))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir gorilla-test.core)
;; @@
;; ->
;;; -main
;;; gaussian
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(-main)
;; @@
;; ->
;;; Hello, World!
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(source -main)
;; @@
;; ->
;;; (defn -main
;;;   &quot;I don&#x27;t do a whole lot ... yet.&quot;
;;;   [&amp; args]
;;;   (println &quot;Hello, World!&quot;))
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(source gaussian)
;; @@
;; ->
;;; (defn gaussian
;;;   [x sigma mu]
;;;   (* (/ 0.4 sigma) (Math/exp (- (/ (* (- x mu) (- x mu)) (* 2 (* sigma sigma)))))))
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(pprint (->> (all-ns)
             (map #(.name %))
             sort))
;; @@
;; ->
<<<<<<< Updated upstream
;;; (cemerick.piggieback
;;;  cheshire.core
;;;  cheshire.factory
;;;  cheshire.generate
;;;  cheshire.parse
;;;  cider.nrepl
;;;  cider.nrepl.middleware.apropos
;;;  cider.nrepl.middleware.classpath
;;;  cider.nrepl.middleware.complete
;;;  cider.nrepl.middleware.info
;;;  cider.nrepl.middleware.inspect
;;;  cider.nrepl.middleware.macroexpand
;;;  cider.nrepl.middleware.ns
;;;  cider.nrepl.middleware.resource
;;;  cider.nrepl.middleware.stacktrace
;;;  cider.nrepl.middleware.test
;;;  cider.nrepl.middleware.trace
;;;  cider.nrepl.middleware.undef
;;;  cider.nrepl.middleware.util.cljs
;;;  cider.nrepl.middleware.util.inspect
;;;  cider.nrepl.middleware.util.java
;;;  cider.nrepl.middleware.util.java.parser
;;;  cider.nrepl.middleware.util.misc
;;;  clj-semver.core
;;;  clj-time.core
;;;  clj-time.format
;;;  cljs-tooling.complete
;;;  cljs-tooling.info
;;;  cljs-tooling.util.analysis
;;;  cljs-tooling.util.misc
;;;  cljs.analyzer
;;;  cljs.closure
;;;  cljs.compiler
;;;  cljs.env
;;;  cljs.repl
;;;  cljs.repl.rhino
;;;  cljs.source-map
;;;  cljs.source-map.base64
;;;  cljs.source-map.base64-vlq
;;;  cljs.tagged-literals
;;;  clojure.core
;;;  clojure.core.incubator
;;;  clojure.core.protocols
;;;  clojure.data.json
;;;  clojure.instant
;;;  clojure.java.classpath
;;;  clojure.java.io
;;;  clojure.main
;;;  clojure.pprint
;;;  clojure.reflect
;;;  clojure.repl
;;;  clojure.set
;;;  clojure.stacktrace
;;;  clojure.string
;;;  clojure.template
;;;  clojure.test
;;;  clojure.tools.macro
;;;  clojure.tools.nrepl
;;;  clojure.tools.nrepl.ack
;;;  clojure.tools.nrepl.bencode
;;;  clojure.tools.nrepl.middleware
;;;  clojure.tools.nrepl.middleware.interruptible-eval
;;;  clojure.tools.nrepl.middleware.load-file
;;;  clojure.tools.nrepl.middleware.pr-values
;;;  clojure.tools.nrepl.middleware.session
;;;  clojure.tools.nrepl.misc
;;;  clojure.tools.nrepl.server
;;;  clojure.tools.nrepl.transport
;;;  clojure.tools.reader
;;;  clojure.tools.reader.default-data-readers
;;;  clojure.tools.reader.impl.ExceptionInfo
;;;  clojure.tools.reader.impl.commons
;;;  clojure.tools.reader.impl.utils
;;;  clojure.tools.reader.reader-types
;;;  clojure.tools.trace
;;;  clojure.uuid
;;;  clojure.walk
;;;  clout.core
;;;  complete.core
;;;  compliment.context
;;;  compliment.core
;;;  compliment.sources
;;;  compliment.sources.class-members
;;;  compliment.sources.keywords
;;;  compliment.sources.local-bindings
;;;  compliment.sources.namespaces-and-classes
;;;  compliment.sources.ns-mappings
;;;  compliment.sources.special-forms
;;;  compliment.utils
;;;  compojure.core
;;;  compojure.handler
;;;  compojure.response
;;;  compojure.route
;;;  dynapath.defaults
;;;  dynapath.dynamic-classpath
;;;  dynapath.util
;;;  gorilla-renderable.core
;;;  gorilla-repl.core
;;;  gorilla-repl.files
;;;  gorilla-repl.nrepl
;;;  gorilla-repl.render-values-mw
;;;  gorilla-repl.renderer
;;;  gorilla-repl.version
;;;  gorilla-repl.websocket-relay
;;;  gorilla-test.core
;;;  new.mongo
;;;  org.httpkit.client
;;;  org.httpkit.server
;;;  ring.middleware.content-type
;;;  ring.middleware.cookies
;;;  ring.middleware.file-info
;;;  ring.middleware.flash
;;;  ring.middleware.head
;;;  ring.middleware.json
;;;  ring.middleware.keyword-params
;;;  ring.middleware.multipart-params
;;;  ring.middleware.nested-params
;;;  ring.middleware.params
;;;  ring.middleware.session
;;;  ring.middleware.session.memory
;;;  ring.middleware.session.store
;;;  ring.util.codec
;;;  ring.util.io
;;;  ring.util.mime-type
;;;  ring.util.response
;;;  ring.util.time
;;;  sicp-1
;;;  somnium.congomongo
;;;  somnium.congomongo.coerce
;;;  somnium.congomongo.config
;;;  test
;;;  user)
=======
;;; (cheshire.core
;;;  cheshire.factory
;;;  cheshire.generate
;;;  cheshire.parse
;;;  cider.nrepl
;;;  cider.nrepl.middleware.apropos
;;;  cider.nrepl.middleware.classpath
;;;  cider.nrepl.middleware.complete
;;;  cider.nrepl.middleware.debug
;;;  cider.nrepl.middleware.format
;;;  cider.nrepl.middleware.info
;;;  cider.nrepl.middleware.inspect
;;;  cider.nrepl.middleware.macroexpand
;;;  cider.nrepl.middleware.ns
;;;  cider.nrepl.middleware.out
;;;  cider.nrepl.middleware.pprint
;;;  cider.nrepl.middleware.refresh
;;;  cider.nrepl.middleware.resource
;;;  cider.nrepl.middleware.stacktrace
;;;  cider.nrepl.middleware.test
;;;  cider.nrepl.middleware.trace
;;;  cider.nrepl.middleware.track-state
;;;  cider.nrepl.middleware.undef
;;;  cider.nrepl.middleware.util.cljs
;;;  cider.nrepl.middleware.util.inspect
;;;  cider.nrepl.middleware.util.instrument
;;;  cider.nrepl.middleware.util.java
;;;  cider.nrepl.middleware.util.misc
;;;  cider.nrepl.print-method
;;;  cider.nrepl.version
;;;  clj-semver.core
;;;  clojure.core
;;;  clojure.core.incubator
;;;  clojure.core.protocols
;;;  clojure.core.server
;;;  clojure.data.json
;;;  clojure.edn
;;;  clojure.instant
;;;  clojure.java.browse
;;;  clojure.java.io
;;;  clojure.java.javadoc
;;;  clojure.java.shell
;;;  clojure.main
;;;  clojure.pprint
;;;  clojure.reflect
;;;  clojure.repl
;;;  clojure.set
;;;  clojure.stacktrace
;;;  clojure.string
;;;  clojure.template
;;;  clojure.test
;;;  clojure.tools.macro
;;;  clojure.tools.nrepl
;;;  clojure.tools.nrepl.ack
;;;  clojure.tools.nrepl.bencode
;;;  clojure.tools.nrepl.middleware
;;;  clojure.tools.nrepl.middleware.interruptible-eval
;;;  clojure.tools.nrepl.middleware.load-file
;;;  clojure.tools.nrepl.middleware.pr-values
;;;  clojure.tools.nrepl.middleware.session
;;;  clojure.tools.nrepl.misc
;;;  clojure.tools.nrepl.server
;;;  clojure.tools.nrepl.transport
;;;  clojure.uuid
;;;  clojure.walk
;;;  clojure.zip
;;;  clout.core
;;;  compojure.core
;;;  compojure.response
;;;  compojure.route
;;;  dk.ative.docjure.spreadsheet
;;;  dynapath.defaults
;;;  dynapath.dynamic-classpath
;;;  dynapath.util
;;;  files
;;;  gorilla-plot.core
;;;  gorilla-plot.util
;;;  gorilla-plot.vega
;;;  gorilla-renderable.core
;;;  gorilla-repl.core
;;;  gorilla-repl.files
;;;  gorilla-repl.handle
;;;  gorilla-repl.html
;;;  gorilla-repl.latex
;;;  gorilla-repl.nrepl
;;;  gorilla-repl.render-values-mw
;;;  gorilla-repl.renderer
;;;  gorilla-repl.table
;;;  gorilla-repl.vega
;;;  gorilla-repl.version
;;;  gorilla-repl.websocket-relay
;;;  gorilla-test.core
;;;  mranderson046.cljfmt.v0v3v0.cljfmt.core
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.coerce
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.comment
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.fn
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.forms
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.integer
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.keyword
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.meta
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.protocols
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.quote
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.reader-macro
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.seq
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.string
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.token
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.uneval
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.node.whitespace
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.core
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.keyword
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.string
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.token
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.utils
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.parser.whitespace
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.potemkin
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.reader
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.base
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.edit
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.find
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.insert
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.move
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.remove
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.seq
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.subedit
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.utils
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.walk
;;;  mranderson046.cljfmt.v0v3v0.rewrite-clj.v0v4v12.rewrite-clj.zip.whitespace
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.complete
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.info
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.util.analysis
;;;  mranderson046.cljs-tooling.v0v1v9.cljs-tooling.util.misc
;;;  mranderson046.compliment.v0v2v6.compliment.context
;;;  mranderson046.compliment.v0v2v6.compliment.core
;;;  mranderson046.compliment.v0v2v6.compliment.sources
;;;  mranderson046.compliment.v0v2v6.compliment.sources.class-members
;;;  mranderson046.compliment.v0v2v6.compliment.sources.keywords
;;;  mranderson046.compliment.v0v2v6.compliment.sources.local-bindings
;;;  mranderson046.compliment.v0v2v6.compliment.sources.namespaces-and-classes
;;;  mranderson046.compliment.v0v2v6.compliment.sources.ns-mappings
;;;  mranderson046.compliment.v0v2v6.compliment.sources.resources
;;;  mranderson046.compliment.v0v2v6.compliment.sources.special-forms
;;;  mranderson046.compliment.v0v2v6.compliment.utils
;;;  mranderson046.compliment.v0v2v6.defprecated.v0v1v2.defprecated.core
;;;  mranderson046.javaclasspath.v0v2v3.clojure.java.classpath
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.dependency
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.dir
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.file
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.find
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.parse
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.reload
;;;  mranderson046.toolsnamespace.v0v2v11.clojure.tools.namespace.track
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.default-data-readers
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.edn
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.impl.commons
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.impl.utils
;;;  mranderson046.toolsreader.v0v10v0.clojure.tools.reader.reader-types
;;;  mranderson046.toolstrace.v0v7v9.clojure.tools.trace
;;;  org.httpkit.client
;;;  org.httpkit.server
;;;  ring.middleware.content-type
;;;  ring.middleware.file-info
;;;  ring.middleware.head
;;;  ring.middleware.json
;;;  ring.middleware.keyword-params
;;;  ring.middleware.params
;;;  ring.util.codec
;;;  ring.util.io
;;;  ring.util.mime-type
;;;  ring.util.response
;;;  ring.util.time
;;;  somnium.congomongo
;;;  somnium.congomongo.coerce
;;;  somnium.congomongo.config
;;;  test
;;;  user)
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir clojure.tools.nrepl.server)
;; @@
;; ->
;;; -&gt;Server
;;; default-handler
;;; default-middlewares
;;; handle
;;; handle*
;;; map-&gt;Server
;;; start-server
;;; stop-server
;;; unknown-op
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc clojure.tools.nrepl.server/map->Server)
;; @@
;; ->
<<<<<<< Updated upstream
;;; -------------------------
;;; clojure.tools.nrepl.server/map-&gt;Server
;;; ([m__5818__auto__])
;;;   Factory function for class clojure.tools.nrepl.server.Server, taking a map of keywords to field values.
=======
;;; -------------------------
;;; clojure.tools.nrepl.server/map-&gt;Server
;;; ([m__6522__auto__])
;;;   Factory function for class clojure.tools.nrepl.server.Server, taking a map of keywords to field values.
>>>>>>> Stashed changes
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc clojure.tools.nrepl.server/->Server)
;; @@
;; ->
;;; -------------------------
;;; clojure.tools.nrepl.server/-&gt;Server
;;; ([server-socket port open-transports transport greeting handler])
;;;   Positional factory function for class clojure.tools.nrepl.server.Server.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc clojure.tools.nrepl.server/start-server)
;; @@
;; ->
;;; -------------------------
;;; clojure.tools.nrepl.server/start-server
;;; ([&amp; {:keys [port bind transport-fn handler ack-port greeting-fn], :or {port 0}}])
;;;   Starts a socket-based nREPL server.  Configuration options include:
;;;  
;;;    * :port — defaults to 0, which autoselects an open port on localhost
;;;    * :bind — bind address, by default any (0.0.0.0)
;;;    * :handler — the nREPL message handler to use for each incoming connection;
;;;        defaults to the result of `(default-handler)`
;;;    * :transport-fn — a function that, given a java.net.Socket corresponding
;;;        to an incoming connection, will return an value satisfying the
;;;        clojure.tools.nrepl.Transport protocol for that Socket.
;;;    * :ack-port — if specified, the port of an already-running server
;;;        that will be connected to to inform of the new server&#x27;s port.
;;;        Useful only by Clojure tooling implementations.
;;; 
;;;    Returns a (map) handle to the server that is started, which may be stopped
;;;    either via `stop-server`, (.close server), or automatically via `with-open`.
;;;    The port that the server is open on is available in the :port slot of the
;;;    server map (useful if the :port option is 0 or was left unspecified.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(Integer/parseInt "9")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"}
;; <=

;; @@
(defn sum-digits-multiple-of-3? [n] (zero? (mod (apply + (map #(Integer/parseInt %) (map str (seq (str n))))) 3)))
(defn multiple-of-3? [n] (zero? (mod n 3)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/multiple-of-3?</span>","value":"#'user/multiple-of-3?"}
;; <=

;; @@
(count (filter sum-digits-multiple-of-3? (range 10000)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>3334</span>","value":"3334"}
;; <=

;; @@
(count (filter multiple-of-3? (range 10000)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>3334</span>","value":"3334"}
;; <=

;; @@
(= (filter sum-digits-multiple-of-3? (range 10000)) (filter multiple-of-3? (range 10000)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(require 'new.mongo)
(dir new.mongo)
;; @@
;; ->
;;; find-matching-words-mongo
;;; info
;;; lower
;;; mckeys
;;; w2cf
;;; words
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(dir sicp-1)
;; @@
;; ->
;;; a
;;; a-plus-abs-b
;;; abs
;;; average
;;; b
;;; f
;;; f1
;;; good-enough-1?
;;; good-enough?
;;; improve
;;; new-if
;;; p
;;; sqrt
;;; sqrt-1
;;; sqrt-iter
;;; sqrt-iter-1
;;; square
;;; sum-of-squares
;;; test
;;; tst
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def wd (java.io.File. "."))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;test/wd</span>","value":"#'test/wd"}
;; <=

;; @@
(seq (.list wd))
;; @@
<<<<<<< Updated upstream
=======
;; ->
;;; (&quot;C:\\Users\\Jeffrey\\.m2\\repository\\aysylu\\loom\\0.5.4\\loom-0.5.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\bouncycastle\\bcmail-jdk14\\138\\bcmail-jdk14-138.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\bouncycastle\\bcprov-jdk14\\138\\bcprov-jdk14-138.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ch\\qos\\logback\\logback-classic\\1.1.2\\logback-classic-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ch\\qos\\logback\\logback-core\\1.1.2\\logback-core-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cheshire\\cheshire\\5.3.1\\cheshire-5.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cider\\cider-nrepl\\0.10.2\\cider-nrepl-0.10.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clatrix\\clatrix\\0.3.0\\clatrix-0.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-blueprints2\\clj-blueprints2\\0.0.1\\clj-blueprints2-0.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-gremlin\\clj-gremlin\\0.0.3\\clj-gremlin-0.0.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-http\\clj-http\\2.0.0\\clj-http-2.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-time\\clj-time\\0.4.4\\clj-time-0.4.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clj-tuple\\clj-tuple\\0.2.2\\clj-tuple-0.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojure-complete\\clojure-complete\\0.2.4\\clojure-complete-0.2.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojureql\\clojureql\\1.0.4\\clojureql-1.0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojurewerkz\\neocons\\3.1.0\\neocons-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clojurewerkz\\support\\1.1.0\\support-1.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\clout\\clout\\1.2.0\\clout-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cn\\guoyukun\\jdbc\\db2jcc\\1.4.2\\db2jcc-1.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\cn\\guoyukun\\jdbc\\db2jcc_license_cu\\1.4.2\\db2jcc_license_cu-1.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\colt\\colt\\1.2.0\\colt-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\ashafa\\clutch\\0.4.0\\clutch-0.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\cemerick\\url\\0.0.6\\url-0.0.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-core\\2.3.1\\jackson-core-2.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\fasterxml\\jackson\\dataformat\\jackson-dataformat-smile\\2.3.1\\jackson-dataformat-smile-2.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\AMDJ\\1.0.1\\AMDJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\BTFJ\\1.0.1\\BTFJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\COLAMDJ\\1.0.1\\COLAMDJ-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\github\\rwl\\JKLU\\1.0.0\\JKLU-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\googlecode\\netlib-java\\netlib-java\\0.9.3\\netlib-java-0.9.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\lowagie\\itext\\2.1.7\\itext-2.1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\microsoft\\sqljdbc4\\3.0\\sqljdbc4-3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\mysql\\connectorj\\5.1.12\\connectorj-5.1.12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\rabbitmq\\amqp-client\\2.8.1\\amqp-client-2.8.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\carmine\\2.12.2\\carmine-2.12.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\encore\\2.32.0\\encore-2.32.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\nippy\\2.10.0\\nippy-2.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\timbre\\4.2.1\\timbre-4.2.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\taoensso\\truss\\1.0.0\\truss-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\blueprints\\blueprints-core\\2.2.0\\blueprints-core-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\gremlin\\gremlin-java\\2.2.0\\gremlin-java-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\tinkerpop\\pipes\\2.2.0\\pipes-2.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\uswitch\\clj-soap\\0.2.3\\clj-soap-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\com\\vijaykiran\\docjure\\1.7.0\\docjure-1.7.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-codec\\commons-codec\\1.10\\commons-codec-1.10.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-fileupload\\commons-fileupload\\1.3\\commons-fileupload-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-httpclient\\commons-httpclient\\3.1\\commons-httpclient-3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-io\\commons-io\\2.4\\commons-io-2.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\compliment\\compliment\\0.2.7\\compliment-0.2.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\compojure\\compojure\\1.1.8\\compojure-1.1.8.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\concurrent\\concurrent\\1.3.4\\concurrent-1.3.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\congomongo\\congomongo\\0.3.3\\congomongo-0.3.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\de\\kotka\\lazymap\\3.1.0\\lazymap-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\defprecated\\defprecated\\0.1.3\\defprecated-0.1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\dom4j\\dom4j\\1.6.1\\dom4j-1.6.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\expresso\\expresso\\0.2.0\\expresso-0.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\fr\\grunwald\\lazymap\\3.1.0\\lazymap-3.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gavagai\\gavagai\\0.3.2\\gavagai-0.3.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-plot\\gorilla-plot\\0.1.4\\gorilla-plot-0.1.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-renderable\\gorilla-renderable\\2.0.0\\gorilla-renderable-2.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\gorilla-repl\\gorilla-repl\\0.3.6\\gorilla-repl-0.3.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\grimradical\\clj-semver\\0.2.0\\clj-semver-0.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\hiccup\\hiccup\\1.0.5\\hiccup-1.0.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\http-kit\\http-kit\\2.1.18\\http-kit-2.1.18.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter-gorilla\\incanter-gorilla\\0.1.0\\incanter-gorilla-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-charts\\1.5.5\\incanter-charts-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-core\\1.5.5\\incanter-core-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-excel\\1.5.5\\incanter-excel-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-io\\1.5.5\\incanter-io-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-latex\\1.5.5\\incanter-latex-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-mongodb\\1.5.5\\incanter-mongodb-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-pdf\\1.5.5\\incanter-pdf-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-sql\\1.5.5\\incanter-sql-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-svg\\1.5.5\\incanter-svg-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter-zoo\\1.5.5\\incanter-zoo-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\incanter\\1.5.5\\incanter-1.5.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\jcommon\\1.0.16\\jcommon-1.0.16.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\incanter\\jfreechart\\1.0.13-no-gnujaxp\\jfreechart-1.0.13-no-gnujaxp.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\instaparse\\instaparse\\1.2.2\\instaparse-1.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\io\\aviso\\pretty\\0.1.21\\pretty-0.1.21.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\javax\\servlet\\servlet-api\\2.5\\servlet-api-2.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\javax\\ws\\rs\\jsr311-api\\1.0\\jsr311-api-1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\jaxen\\jaxen\\1.1.3\\jaxen-1.1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\joda-time\\joda-time\\2.1\\joda-time-2.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\jonase\\kibit\\0.1.2\\kibit-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\junit\\junit\\4.8.2\\junit-4.8.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\lein-kibit\\lein-kibit\\0.1.2\\lein-kibit-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\loom-gorilla\\loom-gorilla\\0.1.0\\loom-gorilla-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\jpountz\\lz4\\lz4\\1.3\\lz4-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\mikera\\core.matrix\\0.10.0\\core.matrix-0.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sf\\opencsv\\opencsv\\2.3\\opencsv-2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\csparsej\\csparsej\\1.1.1\\csparsej-1.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\f2j\\arpack_combined_all\\0.1\\arpack_combined_all-0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jplasma\\core-lapack\\0.1\\core-lapack-0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jplasma\\jplasma\\1.2.0\\jplasma-1.2.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\jtransforms\\jtransforms\\2.4.0\\jtransforms-2.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\parallelcolt\\optimization\\1.0\\optimization-1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\net\\sourceforge\\parallelcolt\\parallelcolt\\0.10.1\\parallelcolt-0.10.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-adb\\1.6.2\\axis2-adb-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-kernel\\1.6.2\\axis2-kernel-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-transport-http\\1.6.2\\axis2-transport-http-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\axis2\\axis2-transport-local\\1.6.2\\axis2-transport-local-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\commons\\commons-pool2\\2.4.2\\commons-pool2-2.4.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-activation_1.1_spec\\1.0.2\\geronimo-activation_1.1_spec-1.0.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-javamail_1.4_spec\\1.7.1\\geronimo-javamail_1.4_spec-1.7.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-jta_1.1_spec\\1.1\\geronimo-jta_1.1_spec-1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-stax-api_1.0_spec\\1.0.1\\geronimo-stax-api_1.0_spec-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\geronimo\\specs\\geronimo-ws-metadata_2.0_spec\\1.1.2\\geronimo-ws-metadata_2.0_spec-1.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpclient\\4.5\\httpclient-4.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpcore\\4.4.1\\httpcore-4.4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\httpcomponents\\httpmime\\4.5\\httpmime-4.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\james\\apache-mime4j-core\\0.7.2\\apache-mime4j-core-0.7.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\neethi\\neethi\\3.0.2\\neethi-3.0.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi-ooxml-schemas\\3.9\\poi-ooxml-schemas-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi-ooxml\\3.9\\poi-ooxml-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\poi\\poi\\3.9\\poi-3.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-api\\1.0M9\\woden-api-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-impl-commons\\1.0M9\\woden-impl-commons-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\woden\\woden-impl-dom\\1.0M9\\woden-impl-dom-1.0M9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\axiom\\axiom-api\\1.2.13\\axiom-api-1.2.13.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\axiom\\axiom-impl\\1.2.13\\axiom-impl-1.2.13.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\ws\\commons\\schema\\XmlSchema\\1.4.7\\XmlSchema-1.4.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlbeans\\xmlbeans\\2.3.0\\xmlbeans-2.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-awt-util\\1.7\\batik-awt-util-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-css\\1.7\\batik-css-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-dom\\1.7\\batik-dom-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-ext\\1.7\\batik-ext-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-svggen\\1.7\\batik-svggen-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-util\\1.7\\batik-util-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\apache\\xmlgraphics\\batik-xml\\1.7\\batik-xml-1.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bcmail-jdk14\\1.38\\bcmail-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bcprov-jdk14\\1.38\\bcprov-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\bouncycastle\\bctsp-jdk14\\1.38\\bctsp-jdk14-1.38.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\clojure\\1.8.0\\clojure-1.8.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.cache\\0.6.3\\core.cache-0.6.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.incubator\\0.1.1\\core.incubator-0.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.logic\\0.8.4\\core.logic-0.8.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.match\\0.2.2\\core.match-0.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.memoize\\0.5.6\\core.memoize-0.5.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\core.unify\\0.5.6\\core.unify-0.5.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.codec\\0.1.0\\data.codec-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.json\\0.2.6\\data.json-0.2.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.priority-map\\0.0.5\\data.priority-map-0.0.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\data.xml\\0.0.8\\data.xml-0.0.8.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\java.jdbc\\0.2.3\\java.jdbc-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\math.combinatorics\\0.0.4\\math.combinatorics-0.0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.analyzer.jvm\\0.1.0-beta12\\tools.analyzer.jvm-0.1.0-beta12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.analyzer\\0.1.0-beta12\\tools.analyzer-0.1.0-beta12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.cli\\0.3.1\\tools.cli-0.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.macro\\0.1.0\\tools.macro-0.1.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.nrepl\\0.2.12\\tools.nrepl-0.2.12.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\clojure\\tools.reader\\0.10.0\\tools.reader-0.10.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jackson\\jackson-core-asl\\1.8.5\\jackson-core-asl-1.8.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jackson\\jackson-mapper-asl\\1.8.5\\jackson-mapper-asl-1.8.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\jettison\\jettison\\1.3\\jettison-1.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\codehaus\\woodstox\\wstx-asl\\3.2.9\\wstx-asl-3.2.9.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\danlarkin\\clojure-json\\1.1\\clojure-json-1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\iq80\\snappy\\snappy\\0.4\\snappy-0.4.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\jblas\\jblas\\1.2.3\\jblas-1.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\mongodb\\mongo-java-driver\\2.9.3\\mongo-java-driver-2.9.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\ow2\\asm\\asm-all\\4.1\\asm-all-4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\scilab\\forge\\jlatexmath\\0.9.6\\jlatexmath-0.9.6.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.7.7\\slf4j-api-1.7.7.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\tcrawley\\dynapath\\0.2.3\\dynapath-0.2.3.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\org\\tukaani\\xz\\1.5\\xz-1.5.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\pathetic\\pathetic\\0.4.0\\pathetic-0.4.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\potemkin\\potemkin\\0.4.1\\potemkin-0.4.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\prismatic\\plumbing\\0.5.2\\plumbing-0.5.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\prismatic\\schema\\1.0.1\\schema-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\proto-repl\\proto-repl\\0.1.2\\proto-repl-0.1.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\riddley\\riddley\\0.1.10\\riddley-0.1.10.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-codec\\1.0.0\\ring-codec-1.0.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-core\\1.2.2\\ring-core-1.2.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\ring\\ring-json\\0.3.1\\ring-json-0.3.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\rplevy-draker\\wabbitmq\\0.3.0\\wabbitmq-0.3.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\slingshot\\slingshot\\0.12.2\\slingshot-0.12.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\stax\\stax-api\\1.0.1\\stax-api-1.0.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\tigris\\tigris\\0.1.1\\tigris-0.1.1.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\wsdl4j\\wsdl4j\\1.6.2\\wsdl4j-1.6.2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xalan\\xalan\\2.6.0\\xalan-2.6.0.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xml-apis\\xml-apis-ext\\1.3.04\\xml-apis-ext-1.3.04.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\.m2\\repository\\xml-apis\\xml-apis\\1.0.b2\\xml-apis-1.0.b2.jar&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\dev-resources&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\resources&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\src&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\target\\base+system+user+dev\\classes&quot;
;;;  &quot;C:\\Users\\Jeffrey\\Documents\\GitHub\\gorilla-test-present\\test&quot;)
;;; 
;; <-
>>>>>>> Stashed changes
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;README.md&quot;</span>","value":"\"README.md\""},{"type":"html","content":"<span class='clj-string'>&quot;data&quot;</span>","value":"\"data\""},{"type":"html","content":"<span class='clj-string'>&quot;.lein-repl-history&quot;</span>","value":"\".lein-repl-history\""},{"type":"html","content":"<span class='clj-string'>&quot;.nrepl-port&quot;</span>","value":"\".nrepl-port\""},{"type":"html","content":"<span class='clj-string'>&quot;test.xlsx&quot;</span>","value":"\"test.xlsx\""},{"type":"html","content":"<span class='clj-string'>&quot;project.clj&quot;</span>","value":"\"project.clj\""},{"type":"html","content":"<span class='clj-string'>&quot;src&quot;</span>","value":"\"src\""},{"type":"html","content":"<span class='clj-string'>&quot;ws&quot;</span>","value":"\"ws\""},{"type":"html","content":"<span class='clj-string'>&quot;.gitignore&quot;</span>","value":"\".gitignore\""},{"type":"html","content":"<span class='clj-string'>&quot;target&quot;</span>","value":"\"target\""},{"type":"html","content":"<span class='clj-string'>&quot;LICENCE.txt&quot;</span>","value":"\"LICENCE.txt\""},{"type":"html","content":"<span class='clj-string'>&quot;.gorilla-port&quot;</span>","value":"\".gorilla-port\""},{"type":"html","content":"<span class='clj-string'>&quot;spreadsheet.xlsx&quot;</span>","value":"\"spreadsheet.xlsx\""}],"value":"(\"README.md\" \"data\" \".lein-repl-history\" \".nrepl-port\" \"test.xlsx\" \"project.clj\" \"src\" \"ws\" \".gitignore\" \"target\" \"LICENCE.txt\" \".gorilla-port\" \"spreadsheet.xlsx\")"}
;; <=

;; @@

;; @@
