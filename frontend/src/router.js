
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderManagementManager from "./components/listers/OrderManagementCards"
import OrderManagementDetail from "./components/listers/OrderManagementDetail"

import PayManager from "./components/listers/PayCards"
import PayDetail from "./components/listers/PayDetail"

import PushMessageManager from "./components/listers/PushMessageCards"
import PushMessageDetail from "./components/listers/PushMessageDetail"


import OrderInfoView from "./components/OrderInfoView"
import OrderInfoViewDetail from "./components/OrderInfoViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orderManagements',
                name: 'OrderManagementManager',
                component: OrderManagementManager
            },
            {
                path: '/orderManagements/:id',
                name: 'OrderManagementDetail',
                component: OrderManagementDetail
            },

            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },
            {
                path: '/pays/:id',
                name: 'PayDetail',
                component: PayDetail
            },

            {
                path: '/pushMessages',
                name: 'PushMessageManager',
                component: PushMessageManager
            },
            {
                path: '/pushMessages/:id',
                name: 'PushMessageDetail',
                component: PushMessageDetail
            },


            {
                path: '/orderInfos',
                name: 'OrderInfoView',
                component: OrderInfoView
            },
            {
                path: '/orderInfos/:id',
                name: 'OrderInfoViewDetail',
                component: OrderInfoViewDetail
            },


    ]
})
