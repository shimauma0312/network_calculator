# 入力値はサーバー側とクライアント側のipアドレスとサブネットマスク(v4, 10進数)
require "paint"

def calc_nw_addr(ip:, subnet:)
  ip_arr = ip.split(".")
  subnet_arr = subnet.split(".")
  
  # ipアドレスを2進数に変換
  ip_arr.each_with_index do |ip, ip_i|
    # 処理上0の場合1桁になってしまうため8桁に合わせる
    if ip_arr[ip_i] == "0"
      format("%08d", ip_arr[ip_i].to_i.to_s(2))
    else
      ip_arr[ip_i] = ip_arr[ip_i].to_i.to_s(2)
    end
  end

  # サブネットマスクを2進数に変換
  subnet_arr.each_with_index do |subnet, subnet_i|
     # 処理上0の場合1桁になってしまうため8桁に合わせる
    if subnet_arr[subnet_i] == "0"
      subnet_arr[subnet_i] = format("%08d", subnet_arr[subnet_i].to_i.to_s(2))
    else
      subnet_arr[subnet_i] = subnet_arr[subnet_i].to_i.to_s(2)
    end
  end

  # ネットワークアドレスを求める
  nw_addr_arr = []
  nw_addr = ""

  # 各セクションごとにipアドレスとサブネットマスクの計算
  4.times do |arr_i|
    8.times do |addr_i|
      # ＆計算
      nw_addr += (ip_arr[arr_i][addr_i].to_i * subnet_arr[arr_i][addr_i].to_i).to_s
    end

    nw_addr_arr << nw_addr.to_i(2).to_s
    nw_addr = ""
  end

  nw_addr = nw_addr_arr.join(".")
  
  return nw_addr
end

def paint_diff_addr(ip1:, ip2:)
  if ip1 != ip2
    return Paint[ip1, :red], Paint[ip2, :red]
  else
    return Paint[ip1, :cyan], Paint[ip2, :cyan]
  end
end


# 処理開始
puts "必要な値を入力してください"

ip_inputs = gets
ip_inputs_arr = ip_inputs.split(" ")

svr_ip = ip_inputs_arr[0]
svr_subnet = ip_inputs_arr[1]

cl_ip = ip_inputs_arr[2]
cl_subnet = ip_inputs_arr[3]

#サーバー視点
from_svr_svr_nw_addr = calc_nw_addr(ip: svr_ip, subnet: svr_subnet)
from_svr_cl_nw_addr = calc_nw_addr(ip: cl_ip, subnet: svr_subnet)
from_svr_svr_nw_addr, from_svr_cl_nw_addr = paint_diff_addr(ip1: from_svr_svr_nw_addr, ip2: from_svr_cl_nw_addr)

#クライアント視点
from_cl_cl_nw_addr = calc_nw_addr(ip: svr_ip, subnet: cl_subnet)
from_cl_svr_nw_addr = calc_nw_addr(ip: cl_ip, subnet: cl_subnet)
from_cl_svr_nw_addr, from_cl_cl_nw_addr = paint_diff_addr(ip1: from_cl_svr_nw_addr, ip2: from_cl_cl_nw_addr)

result = <<~"EOF"
  サーバ: #{svr_ip} / #{svr_subnet}
  クライアント: #{cl_ip} / #{cl_subnet}
  サーバ視点
  サーバーネットワークアドレス: #{from_svr_svr_nw_addr}
  クライアントネットワークアドレス: #{from_svr_cl_nw_addr}
  クライアント視点
  サーバーネットワークアドレス: #{from_cl_svr_nw_addr}
  クライアントネットワークアドレス: #{from_cl_cl_nw_addr}
EOF

puts result





