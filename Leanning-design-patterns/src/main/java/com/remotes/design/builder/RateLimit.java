package com.remotes.design.builder;

import lombok.Builder;
import lombok.Data;

/**
 * Builder 建造者模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
@Data
public class RateLimit {
    private Long limit;
    private String type;

    RateLimit(Long limit, String type) {
        this.limit = limit;
        this.type = type;
    }

    public static RateLimit.RateLimitBuilder builder() {
        return new RateLimit.RateLimitBuilder();
    }

    public static class RateLimitBuilder {
        private Long limit;
        private String type;

        RateLimitBuilder() {
        }

        public RateLimit.RateLimitBuilder limit(Long limit) {
            this.limit = limit;
            return this;
        }

        public RateLimit.RateLimitBuilder type(String type) {
            this.type = type;
            return this;
        }

        public RateLimit build() {
            return new RateLimit(this.limit, this.type);
        }
    }
}
