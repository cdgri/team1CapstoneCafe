#ISTIO
#set 'default' namesapce as mesh-up
kubectl label namespace default istio-injection=enabled --overwrite
#set timeout for 'order' service 
kubectl apply -f - <<EOF
    apiVersion: networking.istio.io/v1alpha3
    kind: VirtualService
    metadata:
      name: vs-order-network-rule
      namespace: default
    spec:
      hosts:
      - order
      http:
      - route:
        - destination:
            host: order
        timeout: 1.0s
EOF

