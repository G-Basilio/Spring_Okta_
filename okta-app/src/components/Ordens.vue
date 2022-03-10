<template>
  <div class="flex-auto">
    <div class="my-2 overflow-x-hidden sm:-mx-2 lg:-mx-1">
      <div class="py-20 align-middle inline-table min-w-full sm:px-32 lg:px-48">
        <div
          class="bg-green-300 bg-opacity-20 border-2 border-green-800 sm:rounded-lg"
        >
          <table class="min-w-full divide-y divide-black">
            <thead class="bg-green-600 bg-opacity-70">
              <th
                scope="col"
                class="px-2 py-5 text-center text-xs text-white uppercase tracking-wider"
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
              ></th>
            </thead>
            <tbody
              class="divide-y divide-black"
              v-for="acao in acoes"
              :key="acao"
            >
              <tr class="font-extrabold">
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.simbol }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.name }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.askMin }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.askMax }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.bidMin }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-gray-900">
                      {{ acao.bidMax }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <button
                      @click="toggleModal(acao)"
                      type="button"
                      class="bg-green-800 bg-opacity-80 hover:bg-yellow-400 text-white font-bold py-2 px-4 border-2 border-gray-800 rounded"
                    >
                      Comprar
                    </button>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <!--Paginação-->
        <div class="py-2 justify-center flex">
          <a
            href="#"
            class="px-4 py-2 font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400"
          >
            Previous
          </a>

          <a
            href="#"
            class="px-4 py-2 font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400"
          >
            1
          </a>
          <a
            href="#"
            class="px-4 py-2 font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400"
          >
            2
          </a>
          <a
            href="#"
            class="px-4 py-2 font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400"
          >
            3
          </a>
          <a
            href="#"
            class="px-4 py-2 font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400"
          >
            Next
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="w-1/12">
    <div
      v-if="showModal"
      class="overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none justify-center items-center flex"
    >
      <div class="relative w-auto my-6 mx-auto max-w-6xl">
        <!--content-->
        <div
          class="border-2 border-green-800 sm:rounded-lg shadow-lg relative flex flex-col w-full bg-green-200 bg-opacity-90 outline-none focus:outline-none"
        >
          <!--header-->
          <div
            class="flex items-start justify-center p-5 border-b border-solid border-black rounded-t"
          >
            <h5 class="text-3xl font-semibold">COMPRAR AÇÃO</h5>
          </div>
          <!--body-->
          <form class="w-full max-w-lg p-10">
            <div class="flex justify-evenly -mx-3 mb-2">
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-widest text-gray-900 text-xs font-extrabold mb-2"
                  for="grid-city"
                >
                  Quantidade
                </label>
                <input
                  v-model="volume"
                  class="appearance-none block w-4/5 bg-green-50 text-gray-900 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text"
                />
              </div>
              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                <label
                  class="block uppercase tracking-widest text-gray-700 text-xs font-extrabold mb-2"
                  for="grid-zip"
                >
                  Preço
                </label>
                <input
                  v-model="price"
                  class="appearance-none block w-10/12 bg-green-50 text-gray-900 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  type="text"
                />
              </div>
            </div>
          </form>
          <!--footer-->
          <div
            class="flex items-center justify-evenly p-6 border-t border-solid border-black rounded-b"
          >
            <button
              class="py-3 px-8 border border-transparent shadow-sm text-sm font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400 focus:outline-none"
              @click="CreteOrdem"
              v-on:click="toggleModal()"
            >
              Confirmar
            </button>
            <button
              class="py-3 px-8 border border-transparent shadow-sm text-sm font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-red-400 focus:outline-none"
              type="button"
              v-on:click="toggleModal(showModal)"
            >
              Cancelar
            </button>
          </div>
        </div>
      </div>
    </div>
    <div
      v-if="showModal"
      class="opacity-25 fixed inset-0 z-40 bg-green-200"
    ></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    acoes: [],
    seila: [],
    acaoCompra: null,
    showModal: false,
    seila1: "",
    name: "",
    stockName: "",
  }),
  created() {
    this.buscar();
    this.setup2();
    this.CreteOrdem();
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
          this.seila = response.data;

          for (var chave in response.data) {
            this.acoes.push({
              id: response.data[chave].id,
              simbol: response.data[chave].stock_symbol,
              name: response.data[chave].stock_name,
              askMin:
                response.data[chave].ask_min == null
                  ? 0
                  : response.data[chave].ask_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              askMax:
                response.data[chave].ask_max == null
                  ? 0
                  : response.data[chave].ask_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              bidMin:
                response.data[chave].bid_min == null
                  ? 0
                  : response.data[chave].bid_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              bidMax:
                response.data[chave].bid_max == null
                  ? 0
                  : response.data[chave].bid_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
            });
          }
        } catch (error) {
          console.log("Ta errado isso aí");
          this.caffeineLevel = `${error}`;
        }
      }
    },
    async selecStock() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          let response = await axios.get(
            `http://localhost:8083/stocks/${this.stockName}`,
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          console.log("oque aparece no stock name");
          console.log(this.stockName);

          this.seila1 = response.data;
          console.log("Aqui é da Stock por nome");
          console.log(this.seila1);
        } catch (error) {
          this.seila1 = `${error}`;
        }
      }
    },
    async setup2() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          let response = await axios.get("http://localhost:8081/user_orders", {
            headers: { Authorization: "Bearer " + accessToken },
          });
          this.order = response.data;
        } catch (error) {
          this.order = `${error}`;
        }
      }
    },

    async CreteOrdem() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          await axios.post(
            "http://localhost:8081/compra",
            {
              id_user: this.id_user,
              id_stock: this.seila1[0].id,
              stock_name: this.name,
              stock_symbol: this.seila1[0].stock_symbol,
              price: this.price,
              status: 1,
              type: this.type,
              volume: this.volume,
              valume_remaining: this.volume,
            },
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );
          console.log("sucesso");
        } catch (error) {
          console.log(error);
        }
      }
      this.setup2();
    },
    async toggleModal(acao) {
      this.acaoCompra = acao;
      this.stockName = this.acaoCompra.name;
      this.showModal = !this.showModal;
    },
  },
};
</script>
