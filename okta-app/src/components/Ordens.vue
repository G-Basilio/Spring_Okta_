<!-- This example requires Tailwind CSS v2.0+ -->
<template>
  <div class="flex flex-col">
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
        <div
          class="shadow overflow-hidden border-b border-black sm:rounded-lg"
        >
          <table class="min-w-full divide-y divide-black">
            <thead class="bg-teal-dark">
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  ID
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Simbolo
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Nome da ação
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Ask Min
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Ask Max
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Bid Min
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Bid Max
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                </th>
            </thead>
            <tbody
              class="bg-teal-lightest divide-y divide-black"
              v-for="(acao, i) in acoes"
              :key="i"
            >
              <tr>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm font medium text-black">
                        {{acao.id }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-black">
                        {{acao.simbol }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">                  
                      <div class="text-sm medium text-black">
                        {{acao.name }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-black">
                        {{acao.askMin }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">                  
                      <div class="text-sm medium text-black">
                        {{acao.askMax }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-black">
                        {{acao.bidMin }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-black">
                        {{acao.bidMax }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <button class="bg-teal-dark hover:bg-teal-darker text-white font-bold py-2 px-4 border border-black rounded">
                          Comprar
                          </button>
                        <!-- <a href="#" class="text-grey-lighter font-bold py-1 px-3 rounded text-xs bg-green hover:bg-green-dark">Comprar</a> -->
                      </div>
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    acoes: [],
  }),
  created() {
    this.buscar();
  },
  methods: {
    async buscar() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get(`http://localhost:8083/stocks`, {
            headers: { Authorization: "Bearer " + accessToken },
          });
          console.log(response);

          for (var chave in response.data) {
            this.acoes.push({
              id: response.data[chave].id,
              simbol: response.data[chave].stock_symbol,
              name: response.data[chave].stock_name,
              askMin:
                response.data[chave].ask_min == null
                  ? 0
                  : response.data[chave].ask_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 1,
                    }),
              askMax:
                response.data[chave].ask_max == null
                  ? 0
                  : response.data[chave].ask_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 1,
                    }),
              bidMin:
                response.data[chave].bid_min == null
                  ? 0
                  : response.data[chave].bid_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 1,
                    }),
              bidMax:
                response.data[chave].bid_max == null
                  ? 0
                  : response.data[chave].bid_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 1,
                    }),                    
            });
          }
        } catch (error) {
          console.log("Ta errado isso aí");
          this.caffeineLevel = `${error}`;
        }
      }
    },
  },
};
</script>