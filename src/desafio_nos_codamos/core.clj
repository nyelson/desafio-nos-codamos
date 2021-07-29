(ns desafio-nos-codamos.core)

(refer-clojure :exclude [range iterate format max min])
(use 'java-time)

(println "Início do projeto - Core")

(def cliente  { :nome "Almerindo", :cpf "22667862023", :email "almerindo@nubank.com.br"})
(def cartao   { :numero "5410133996442556", :cvv "984", :validade (format "dd/MM/yyyy" (zoned-date-time 2022 10 20)), :limite 10000}) ;(java.time.LocalDateTime/now)
(def compras  [ { :data (format "dd/MM/yyyy" (zoned-date-time 2021 10 20)), :valor 1000,  :estabelecimento "Adidas",        :categoria "Vestuário"   },
                { :data (format "dd/MM/yyyy" (zoned-date-time 2021 03 13)), :valor 40,    :estabelecimento "Burguer King",  :categoria "Restaurante" },
                { :data (format "dd/MM/yyyy" (zoned-date-time 2021 05 29)), :valor 300,   :estabelecimento "Nike",          :categoria "Vestuário"   } ])

(defn agrupa-categorias
  "Agrupa e retorna uma lista de acordo com a categoria"
  [lista]
  (group-by :categoria lista))

(defn retorna-simbolo-por-categoria
  "Retorna o novo simbolo de acordo com a categoria passada e presente na lista agrupada"
  [lista categoria]
  (get lista categoria))

(defn somatorio-total
  [lista]
  (->> lista (map :valor) (reduce +)))

(def compras-categorizadas  (agrupa-categorias compras))
(def lista-vestuario        (retorna-simbolo-por-categoria compras-categorizadas "Vestuário"))
(def lista-restaurante      (retorna-simbolo-por-categoria compras-categorizadas "Restaurante"))

(println "O total das compras referente a categoria vestuário é de:" (somatorio-total lista-vestuario))
(println "O total das compras referente a categoria restaurante é de:" (somatorio-total lista-restaurante))
(println "O total das compras referente fatura é de:" (somatorio-total compras))

(println (assoc-in cliente [:cartaoRef] (assoc-in cartao [:comprasRef] compras)))