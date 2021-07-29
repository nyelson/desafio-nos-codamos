(ns desafio-nos-codamos.core)

(println "Início do projeto - Core")

(def cliente  {:nome "Almerindo", :cpf "22667862023", :email "almerindo@nubank.com.br"})
(def cartao   {:numero "5410133996442556", :cvv "984", :validade "30/12/2022" , :limite 10000}) ;(java.time.LocalDateTime/now)
(def compras  [ {:data "30/12/2022", :valor 1000,  :estabelecimento "Adidas",        :categoria "Vestuário"},
                {:data "30/12/2022", :valor 40,    :estabelecimento "Burguer King",  :categoria "Restaurante"},
                {:data "30/12/2022", :valor 300,   :estabelecimento "Nike",          :categoria "Vestuário"}])

;criar uma função para retornar o group by
;criar uma função para pegar o simbolo específico na lista agrupada
;colocar o resultado em um simbolo de agrupamento
;criar uma função para retornar por categoria

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

(def compras-categorizadas (agrupa-categorias compras))
(def lista-vestuario       (retorna-simbolo-por-categoria compras-categorizadas "Vestuário"))
(def lista-restaurante     (retorna-simbolo-por-categoria compras-categorizadas "Restaurante"))

(println "O total das compras referente a categoria vestuário é de:" (somatorio-total lista-vestuario))
(println "O total das compras referente a categoria restaurante é de:" (somatorio-total lista-restaurante))
(println "O total das compras referente fatura é de:" (somatorio-total compras))

;(println (assoc-in cartao compras (map compras)))
;(println (conj cartao 1))
;(println (def cartao (assoc cartao compras (map compras))))
;(println cartao)
